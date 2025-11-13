package system;



 class BookNotFoundException extends Exception{
	public BookNotFoundException(String message) {
			super(message);
	}
}

 class MemberNotFoundException extends Exception{
	 public MemberNotFoundException(String mes) {
		 super(mes);
	 }
 }
 class BookNotAvaliableException extends Exception{
	 public BookNotAvaliableException(String mess) {
		 super(mess);
	 }
 }