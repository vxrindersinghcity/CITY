class Drawing {

  Drawing() {
    
  }

  void gridLines(int start, int end, int spacing) {
    translate(width/2, height/2);
    for (int pos=start; pos<end; pos+=spacing) {
      if (pos==0) {
        strokeWeight(3);
      } else {
        strokeWeight(1);
      }
      line(start, pos, end, pos);
      line(pos, start, pos, end);
    }
  }

  void drawVector(PVector p) {
    line(0, 0, p.x*spacing, p.y*-spacing);
  }

  void drawVector(PVector p, int weight) {
    strokeWeight(weight);
    line(0, 0, p.x*spacing, p.y*-spacing);
    strokeWeight(1);
  }
  void drawVector(PVector origin, PVector p) {
    line(origin.x*spacing, origin.y*-spacing, origin.x*spacing+p.x*spacing, origin.y*-spacing+p.y*-spacing);
  }
}
