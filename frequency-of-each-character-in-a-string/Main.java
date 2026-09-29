class main{
    public static void main(String[] args){
        String str = "im a motherfucking gabru";
        Map<Character, Long> charMap = str.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
            Function.identity(), Collectors.counting()
        ));

        charMap.forEach((ch, count) -> System.out.Println(ch + " : " + count));
    }
}