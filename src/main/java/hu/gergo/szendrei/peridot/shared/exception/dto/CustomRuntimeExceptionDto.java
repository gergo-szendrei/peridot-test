package hu.gergo.szendrei.peridot.shared.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class CustomRuntimeExceptionDto extends RuntimeException {
    private String message;
    private Exception originalException;
}
