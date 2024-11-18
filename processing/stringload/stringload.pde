// Read a text file into an array names 'lines' with loadStrings()
String[] lines = loadStrings("namesData.txt");
// Split the second String at each comma, into a new array of strings, or tokens :
String [] tokens = split(lines[1],",");
 
// Print the array of tokens:
printArray(tokens);
 
// Print the 5th element in this array of tokens :
println(tokens[4]);
