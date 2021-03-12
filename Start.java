package your.package

class Start implements Runnable{
  Thread game;
  Boolean running == true;
  public static void main(String[] args){
    new Start().start();
  }
  public void start(){
    game = new Thread(this, "game");
    game.start();
  }
  public void run(){
    init();
    while(running == true){
     update();
     render();
    }
  }
  public void init(){
    
  }
  public void update(){
    
  }
  public void render(){
    
  }
}
