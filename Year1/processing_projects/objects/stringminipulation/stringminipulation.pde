void setup()
{
    String message = "Hello from CreativeCoding on Friday";
 
   println(message.toUpperCase());
    println(message.toLowerCase());
    println(message.length());
    println("'"+message.charAt(5)+ "'");
    if(message.contains("day")){
        println("day found");
    }else{
        println("not found");
    }
    
     String message1 = "Our first two weeks of CreativeCoding are nearly over";
 
   println(message1.toUpperCase());
    println(message1.toLowerCase());
    println(message1.length());
    println("'"+message1.charAt(5)+ "'");
    if(message1.contains("day")){
        println("day found");
    }else{
        println("not found");
    }
}
