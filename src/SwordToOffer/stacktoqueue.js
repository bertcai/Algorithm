var stack1 = [], stack2=[];
function push(node)
{
    stack1.push(node);
    // write code here
}
function pop()
{
    if(stack2.length!=0){
        return stack2.pop();
    } else{
        let length = stack1.length;
        while(length!=0){
            stack2.push(stack1.pop())
            length--;
        }
        return stack2.pop();
    }
    // write code here
}