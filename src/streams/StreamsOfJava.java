package streams;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOfJava {

	public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2){
		
		
		List<Integer> result=Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	}

}
