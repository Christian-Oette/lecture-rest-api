package de.oette.lecture.A05.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/hash-secured")
@Validated
public class HashSecurityController {

    private static final String SALT = "23asdfadsf23aflökjfdöwrejafjaösfas3";

    @GetMapping
    public String getAccess(@RequestParam @NotNull String user,
                            @RequestParam @NotNull String hash,
                            @RequestParam @NotNull long timestampValidUntil) {

        long now = System.currentTimeMillis();
        if (timestampValidUntil < now) {
            throw new CustomAccessDeniedException("No longer valid");
        }

        String calculatedHash = calculateHash(user,SALT, String.valueOf(timestampValidUntil));
        if (calculatedHash.equals(hash)) {
            return "Access granted";
        } else {
            throw new CustomAccessDeniedException("Wrong hash");
        }

    }

    private String calculateHash(String... strings) {
        try {
            String concat = String.join("#", strings);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = messageDigest.digest(concat.getBytes(Charset.forName("UTF-8")));
            return String.copyValueOf(Hex.encode(digest));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        long valid60Seconds = System.currentTimeMillis() + 60 * 1000;
        System.out.println(valid60Seconds);

        String calculatedHash = new HashSecurityController().calculateHash("Max",SALT, String.valueOf(valid60Seconds));
        System.out.println(calculatedHash);
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    private class CustomAccessDeniedException extends AccessDeniedException {

        public CustomAccessDeniedException(String msg) {
            super(msg);
        }
    }
}
