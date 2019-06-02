package employee;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class DuplicateEntryException extends Exception {
    private final String message;
}
