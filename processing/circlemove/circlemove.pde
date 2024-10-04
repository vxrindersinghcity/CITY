
float[] x =new float[4];
float[] y =new float[4];

boolean touched =false;
void setup() {
  size(400, 400);
  for(int i=0;i<4;i++){
    x[i]=200;
    y[i]=200;
  }
  
  
}
void draw(){
    
    if(x[1]==0){
      touched=true;
    }if(touched){
       oppositemove();
    }if(touched && x[1]>400){
       touched=false;
    }if(touched==false){
    normalmove();
    }
    println(x[1]);
}
void normalmove(){
  ellipse(x[0]++,y[0]++,100,100);
  ellipse(x[1]--,y[1]--,100,100);
  ellipse(x[2]++,y[2]--,100,100);
  ellipse(x[3]--,y[3]++,100,100);
  
}
void oppositemove(){
  ellipse(x[0]--,y[0]--,100,100);
  ellipse(x[1]++,y[1]++,100,100);
  ellipse(x[2]--,y[2]++,100,100);
  ellipse(x[3]++,y[3]--,100,100);
}
