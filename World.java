package assignment2;

public class World {
    private Caterpillar cater;
    private Position nextFoodPos;
    private Region region;
    private ActionQueue actionQueue;
    private TargetQueue foodPosQueue;
    private GameState gameState;

    public World(TargetQueue t, ActionQueue a){
        this.region = new Region(0, 0, 15, 15);
        this.actionQueue = a;
        this.foodPosQueue = t;
        this.nextFoodPos = this.foodPosQueue.dequeue();
        this.cater = new Caterpillar();
        this.gameState = GameState.MOVE;
    }

    public void step(){
        if (this.actionQueue.isEmpty()){
            this.gameState = GameState.NO_MORE_ACTION;
        }

        if (this.gameState != GameState.MOVE && this.gameState != GameState.EAT){
            return;
        }

        Position currHead = this.cater.getHead();
        Direction moveDir = this.actionQueue.dequeue();
        Position newPos = new Position(currHead);

        if (moveDir == Direction.NORTH){
            newPos.moveNorth();
        }else if(moveDir == Direction.SOUTH){
            newPos.moveSouth();
        }else if(moveDir == Direction.EAST){
            newPos.moveEast();
        }else if(moveDir == Direction.WEST){
            newPos.moveWest();
        }

        if (!this.region.contains(newPos)){
            this.gameState = GameState.WALL_COLLISION;

        }else if(this.cater.selfCollision(newPos)){
            this.gameState = GameState.SELF_COLLISION;

        }else if(newPos.equals(this.nextFoodPos)){
            this.cater.eat(newPos);

            if (this.foodPosQueue.isEmpty()){
                this.gameState = GameState.DONE;

            }else{
                this.nextFoodPos = foodPosQueue.dequeue();
                this.gameState = GameState.EAT;
            }
        }else{
            this.cater.move(newPos);
            this.gameState = GameState.MOVE;
        }
    }

    public GameState getState(){
        return this.gameState;
    }

    public Caterpillar getCaterpillar(){
        return this.cater;
    }

    public Position getFood(){
        return this.nextFoodPos;
    }

    public boolean isRunning(){
        return this.gameState == GameState.MOVE || this.gameState == GameState.EAT;
    }

}
