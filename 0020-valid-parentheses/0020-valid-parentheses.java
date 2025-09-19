class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        char[] ch=s.toCharArray();
        char[] stack=new char[s.length()];
        int top=0;
        for(int i=0;i<ch.length;i++){
            switch(ch[i]){
                case '(','{','[':
                    stack[top++]=ch[i];
                    break;
                case ')':
                    if(top==0||stack[--top]!='(') return false;
                    break;
                case '}':
                    if(top==0||stack[--top]!='{') return false;
                    break;
                case ']':
                    if(top==0||stack[--top]!='[') return false;
                    break;
            }
        }
        return top==0;
    }
}