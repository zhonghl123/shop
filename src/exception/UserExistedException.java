package exception;

public class UserExistedException extends Exception {
	public String toString(){
		return "The username is already existed";
	}
}
