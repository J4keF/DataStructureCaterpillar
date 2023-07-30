package assignment2;

public class TargetQueue extends MyQueue<Position> {
    MyStack<String> stack;

    public TargetQueue(){
        super();
        this.stack = new MyStack<String>();
    }

    public void clear(){
        super.clear();
        this.stack.clear();
    }

    //HELPER isNumerical
    public static boolean isNumerical(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public void addTargets(String s){
        if (s.length() != 0 && (s.charAt(0) != '(' && s.charAt(0) != '.')){
            throw new IllegalArgumentException("Invalid input");
        }
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(' && stack.isEmpty()){
                this.stack.push("(");
            }else if (Character.isDigit(curr)){
                num += curr;
            }else if (curr == ',' && num.length() != 0 && isNumerical(num)){
                this.stack.push(num);
                this.stack.push(",");
                num = "";
            }else if (curr == ')' && this.stack.getSize() == 3 && this.stack.pop().equals(",") && isNumerical(this.stack.peek()) && num.length() != 0 && (i == s.length() - 1 || s.charAt(i + 1) == '.')){
                if (isNumerical(num)) {
                    int y = Integer.parseInt(num);
                    String xS = this.stack.pop();
                    if (isNumerical(xS)) {
                        int x = Integer.parseInt(xS);
                        if (this.stack.pop().equals("(")) {
                            this.enqueue(new Position(x, y));
                        } else {
                            throw new IllegalArgumentException("Invalid input");
                        }
                    } else{
                        throw new IllegalArgumentException("Invalid input");
                    }
                } else{
                    throw new IllegalArgumentException("Invalid input");
                }
                num = "";
            }else if (curr == '.' && this.stack.isEmpty() && num.length() == 0 && (i == s.length() - 1 || s.charAt(i + 1) == '(')){
                continue;
            }else{
                throw new IllegalArgumentException("Invalid input");
            }
        }

        if(!this.stack.isEmpty()){
            throw new IllegalArgumentException("Final stack is not empty");
        }

    }

// JAKES TESTING
//    public static void main (String[] args){
//        TargetQueue t = new TargetQueue();
//        t.addTargets("().()");
//        for (int i = 0; i < 6; i++) {
//            Position pos1 = t.dequeue();
//            int gotX = pos1.getX();
//            int gotY = pos1.getY();
//            System.out.println(gotX + " " + gotY);
//        }
//    }
}
