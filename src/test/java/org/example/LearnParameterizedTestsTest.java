package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

/**
 * @ParameterizedTest
 * @ValueSource - These are the values that are passed to the @ParameterizedTest method's parameter when tests run
 * @EmptySource - This is a blank input to a ParameterizedTest
 * @NullSource - This is a null input to a ParametrizedTest
 * @NullAndEmptySource - This is an input of null and blank into a ParameterizedTest
 *
 */
public class LearnParameterizedTestsTest {

    public enum Values {
        ABC, XYZ, WXY, PQX, NJWM
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,5,6})
    public void checkGreaterThan4(int num) {
        Assertions.assertTrue(num > 4);
    }

    /**
     * @EnumSource - This takes values from an enum as shown by method below
     * @param values the enums being tested
     */
    @ParameterizedTest
    @EnumSource(Values.class)
    public void testValuesAlways3Letters(Values values) {
        Assertions.assertEquals(3, values.toString().length());
    }

    /**
     * You can specify which Enum values you what tested by using the mode on the @EnumSource as below
     * Enum.Mode.EXCLUDE will exclude all values in names, in source enum from being tested
     * Enum.Mode.MATCH_ALL will test only the values that match the names
     * @param values
     */
    @ParameterizedTest
    @EnumSource(value = Values.class, mode = EnumSource.Mode.EXCLUDE, names = {"NJWM"})
    public void testValuesAlways3Letters1(Values values) {
        Assertions.assertEquals(3, values.toString().length());
    }

    /**
     * @MethodSource its like @ValueSource but now the values are from a static
     * method which will be referenced as the @MethodSource value the static method must return a Stream of data
     * as shown below it can be a stream of any class type
     * @param dob
     */
    @ParameterizedTest
    @MethodSource("dobs")
    public void testDOBFormat(String dob) {
        Assertions.assertEquals(3, dob.split("-").length);
    }

    /**
     * The Source Method.
     * @return
     */
    static Stream<String> dobs() {
        Stream.Builder<String> builder = Stream.builder();
        int j = 0;
        for (int i = 1; i < 10; i++) {
            String pair = Integer.toString(j+i);
            pair = pair.length() == 1 ? "0" + pair : pair;
            builder.add("2026-0"+i+"-"+pair);
            j +=1;
        }
        return builder.build();
    }


    @ParameterizedTest
    @CsvSource({
            "Zambezi,4,beer",
            "Black Label,5,beer",
            "Two Keys,45,liquor",
            "Southern Comfort,18,liquor"
    })
    public void testIsLiquorFunction(String beverage, int alcoholContent, String alcoholType) {
        System.out.println(beverage + ": " + alcoholContent + "%");
        boolean expected = alcoholType.equals("liquor");
        Assertions.assertEquals(expected, isLiquor(alcoholContent));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/drinks.csv")
    public void testIsBeerFunction(String beverage, int alcoholContent, String alcoholType) {
        System.out.println(beverage + ": " + alcoholContent + "%");
        boolean expected = alcoholType.equals("beer");
        Assertions.assertEquals(expected, isBeer(alcoholContent));
    }


    public boolean isLiquor(int alcoholContent) {
        return alcoholContent > 10;
    }

    public boolean isBeer(int alcoholContent) {
        return alcoholContent <= 10;
    }
    




}
