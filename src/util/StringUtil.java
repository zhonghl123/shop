package util;

public class StringUtil {
	public static String parseStrArray2Str(String[] strs){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<strs.length; i++){
			sb.append(strs[i]+";");
		}
		return sb.toString();
	}
	public static String[] toStrArray(String str){
		return str.split(";");
	}
	public static void main(String[] args){
		StringUtil su = new StringUtil();
		String[] strs = {"apple","office"};
		String st = "a;b;s;sdfas;";
		System.out.println(su.parseStrArray2Str(strs));
		for (int i = 0; i<su.toStrArray(su.parseStrArray2Str(strs)).length; i++){
			System.out.println(su.toStrArray(su.parseStrArray2Str(strs))[i]);
		}
	}
}
