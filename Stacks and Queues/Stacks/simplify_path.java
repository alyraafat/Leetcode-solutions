//Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

//In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

//The canonical path should have the following format:

//-The path starts with a single slash '/'.
//-Any two directories are separated by a single slash '/'.
//-The path does not end with a trailing '/'.
//-The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')

//Return the simplified canonical path.

class Solution {
    public String simplifyPath(String path) {
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<path.length();){
            char c = path.charAt(i);        
            if(s.empty()){
                s.push(c);
            }else{
                if(s.peek()=='/'&&c=='/'){
                    i++;
                }else if(c=='/'){
                    String dots = "";
                    while(s.peek()=='.'){
                        dots+=s.pop();
                    }
                    if(s.peek()=='/'){
                        if(dots.length()>2){
                            for(int j=0;j<dots.length();j++){
                                s.push(dots.charAt(j));
                            }
                            s.push('/');
                            i++;
                        }else if(dots.length()==2){
                            s.pop();
                            if(s.empty()) s.push('/'); 
                            while(s.peek()!='/'){
                                s.pop();
                            }
                        }else if(dots.length()==1){
                            i++;
                        }
                        else{
                            s.push(c);
                            i++;
                        }
                    }else{
                        for(int j=0;j<dots.length();j++){
                            s.push(dots.charAt(j));
                        }
                        s.push('/');
                        i++;
                    }
                    
                }else{
                    s.push(c);
                    i++;
                }
            }
        }
        String out="";
        if(s.peek()=='.'){
            String dots = "";
            while(s.peek()=='.'){
                dots+=s.pop();
            }
            if(s.peek()=='/'){
                if(dots.length()>2){
                    for(int j=0;j<dots.length();j++){
                        s.push(dots.charAt(j));
                    }
                }else if(dots.length()==2){
                    s.pop();
                    if(s.empty()) s.push('/'); 
                    while(s.peek()!='/'){
                        s.pop();
                    }
                }
            }else{
                for(int j=0;j<dots.length();j++){
                    s.push(dots.charAt(j));
                }
            }
            
        }
        if(s.peek()=='/'){
            char c = s.pop();
            if(s.empty()) s.push(c);
        }
        while(!s.empty()) out=s.pop()+out;
        return out;
    }
}
