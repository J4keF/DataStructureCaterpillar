package assignment2;

public class ActionQueue extends MyQueue<Direction>{
    MyStack<String> stack = new MyStack<String>();

    public ActionQueue(){
        super();
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

    //TODO - ALL EDGE CASES
    public void loadFromEncodedString(String s){
        if (isNumerical(s)) {
            throw new IllegalArgumentException("Can't be just a number");
        }

        int i = 0;
        String num = "";
        while (i < s.length()){
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                num += curr;
            }else if(curr == '[' && isNumerical(num)){
                int openIndex = i;
                this.stack.push("[");

                while (!stack.isEmpty()){
                    i++;
                    if (i >= s.length()){
                        throw new IllegalArgumentException("Invalid input");
                    }
                    char c = s.charAt(i);
                    if (c == '['){
                        this.stack.push("[");
                    }else if (c == ']'){
                        if (s.charAt(i - 1) == '['){
                            throw new IllegalArgumentException("Invalid input");
                        }
                        this.stack.pop();
                    }
                }

                for (int x = 0; x < Integer.parseInt(num); x++) {
                    loadFromEncodedString(s.substring(openIndex + 1, i));
                }

                num = "";
            }else if(curr == 'N' || curr == 'E' || curr == 'S' || curr == 'W'){
                if (num.length() == 0){
                    switch(curr){
                        case 'N':
                            this.enqueue(Direction.NORTH);
                            break;
                        case 'E':
                            this.enqueue(Direction.EAST);
                            break;
                        case 'S':
                            this.enqueue(Direction.SOUTH);
                            break;
                        case 'W':
                            this.enqueue(Direction.WEST);
                            break;
                    }
                }else{
                    throw new IllegalArgumentException("Invalid input");
                }
            }else{
                throw new IllegalArgumentException("Invalid input");
            }
            i++;
        }
    }

//// JAKES TESTER CODE
//    public static void main (String[] args){
//        ActionQueue a = new ActionQueue();
//        a.loadFromEncodedString("E2[10[W]]");
//        for (int i = 0; i < 21; i++) {
//            Direction dir = a.dequeue();
//            System.out.println(dir);
//        }
//    }
}
