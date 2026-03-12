class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] paths = path.split("/");

        for(String part : paths){

            if(part.equals("") || part.equals(".")) continue;

            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(String dir : stack){
            sb.append("/").append(dir);
        }

        if(sb.length() == 0) return "/";

        return sb.toString();
    }
}