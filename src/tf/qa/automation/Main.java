package tf.qa.automation;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) {
        final int age = 18;
        final int limit = 4;
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        Map<String, Long> filtered = boys.stream()
                .filter(b -> b.getAge() >= age)
                .map(b -> b.getName())
                .sorted()
                .distinct()
                .limit(limit)
                .collect(Collectors.toMap(Function.identity(), V -> boys.stream()
                        .filter(b -> b.getName().equals(V))
                        .count() - 1));


        System.out.println(filtered);


    }
}