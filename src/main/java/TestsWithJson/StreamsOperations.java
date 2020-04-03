package TestsWithJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsOperations {
    public static void main(String[] args){
        List<String> nameList = new ArrayList<String>();
        nameList.add("Bulat");
        nameList.add("Alice");
        nameList.add("ahut");
        nameList.add("Shon");
        nameList.add("Greogry");
        System.out.println(nameList.get(0).startsWith("f"));

        Long namesWithA = nameList.stream().filter(i -> i.startsWith("A")).count();
        System.out.println(namesWithA);

        nameList.stream().filter(i -> i.length()>4).forEach( i -> System.out.println(i));
        nameList.stream().filter(i->i.length()>4).limit(1).forEach(i-> System.out.println("this is only one printed result: "+i));
        nameList.stream().map(i->i.toUpperCase()).filter(i->i.startsWith("A")).forEach(s-> System.out.println(s));

        List<String> names = Arrays.asList("ads","asdfas","yhjt");
        names.stream().map(i->i.startsWith("a")).forEach(i-> System.out.println(i));
        names.stream().map(i->i.toUpperCase()).filter(i->i.startsWith("A")).sorted().forEach(i-> System.out.println(i));

        Stream<String> newStream = Stream.concat(names.stream(), nameList.stream());
        //newStream.forEach(i-> System.out.println(i)); todo: stream has already been operated upon or closed
        System.out.println(newStream.anyMatch(s->s.equalsIgnoreCase("ads")));

    }
}
