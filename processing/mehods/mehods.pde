void setup(){
 size(400,400);
 
}
void draw(){
 drawObject(100,200);
 drawObject(10,10);
}

void drawObject(int x,int y){
 rect(x,y,200,100);
 ellipse(x+50,y+40,70,70);
 line(x+20,y+40,x+80,y+40);
}
