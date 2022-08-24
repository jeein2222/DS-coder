function ajax_send(frm){ //질문 저장
    const formData=$("#record-form").serializeObject();
    const accessToken=localStorage.getItem("token");
    $.ajax({
        url:'http://localhost:8080/ds-sw/question/create',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(formData),
        beforeSend:function (xhr){
                        xhr.setRequestHeader("Content-type","application/json"),
                        xhr.setRequestHeader("Authorization","Bearer "+accessToken);
                    },
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    clear();
    return false;
}

function clear(){
    const title=document.getElementById("title");
    const question=document.getElementById("question");
    const code=document.getElementById("code");
    title.value="";
    question.value="";
    code.value="";
}





