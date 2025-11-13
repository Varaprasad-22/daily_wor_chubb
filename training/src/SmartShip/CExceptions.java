package SmartShip;
import java.util.*;

class InvalidPackageException extends Exception {
    public InvalidPackageException(String msg) { super(msg); }
}

class AgentNotAvailableException extends Exception {
    public AgentNotAvailableException(String msg) { super(msg); }
}

class RouteUnavailableException extends Exception {
    public RouteUnavailableException(String msg) { super(msg); }
}

class DuplicateEntryException extends Exception {
    public DuplicateEntryException(String msg) { super(msg); }
}

class OverloadException extends Exception {
    public OverloadException(String msg) { super(msg); }
}
