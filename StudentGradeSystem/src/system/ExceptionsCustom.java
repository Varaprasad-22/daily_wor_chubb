package system;

 class InvalidMarks extends Exception {
	 public InvalidMarks(String msg) {
		 super(msg);
	 }
}
 class NoGradesException extends Exception {
	    public NoGradesException(String msg) { super(msg); }
	}

	class StudentNotFoundException extends Exception {
	    public StudentNotFoundException(String msg) { super(msg); }
	}
