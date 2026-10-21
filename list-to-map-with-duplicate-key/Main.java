public class Main{
    private Map<Long, Product> toMapKeepHigherPrice(List<Product> products){
        return products.stream()
        .collect(Collectors.toMap(
            Product::id,
            Fuction.identity(),
            (existing, replacement) ->  
                existing.price() >= replacement.price() ?
                existing : replacement
        ));
    }

    public static void main(String[] args){

    }
}