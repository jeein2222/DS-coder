
window.onload = function ajax_get(){ //retrieve
    const currentDiv=document.getElementById('question_list');
    const accessToken=localStorage.getItem("token");
    $.ajax({
            url : 'http://localhost:8080/ds-sw/question/retrieve',
            dataType :"json",
            beforeSend:function (xhr){
                xhr.setRequestHeader("Content-type","application/json"),
                xhr.setRequestHeader("Authorization","Bearer "+accessToken);
            },
            success : function(data) {
                        let d=data.data;
                        console.log(d);
                        for (let i=0;i<d.length;i++){
                            const button=document.createElement("button");
                            const img=document.createElement("img");

                            const title=document.createElement("h6");
                            const question=document.createElement("p");
                            const code=document.createElement("p");
                            const id=document.createElement("p");

                            img.setAttribute("src","/img/question_Img.JPG");

                            title.setAttribute("id","atitle");
                            title.setAttribute("style","font-weight:bold;")

                            question.setAttribute("id","aquestion");

                            code.setAttribute("id","acode");
                            id.setAttribute("id","aid");


                            title.innerHTML=d[i]['title']
                            question.innerHTML=d[i]['question']
                            code.innerHTML=d[i]['code'];
                            id.innerHTML=d[i]['id'];

                            button.setAttribute("style","background-color:white;");
                            button.appendChild(img);
                            button.appendChild(title);
                            button.appendChild(question);
                            button.appendChild(code);
                            button.appendChild(id);


                            button.addEventListener("click",getQuestionInfo);
                            currentDiv.appendChild(button);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
}

function getQuestionInfo(e){ //하단 틀에 정보 넣기
    if (e.target !== e.currentTarget)
            return;
    const a = e.target;
    let listChild=a.childNodes;
    console.log(listChild);

    let id=document.getElementById("id");
    let title=document.getElementById("title");
    let question=document.getElementById("question");
    let code=document.getElementById("code");


    id.value=listChild[4].innerHTML;
    title.value=listChild[1].innerHTML;
    question.value=listChild[2].innerHTML;
    code.value=listChild[3].innerHTML;

}

function ajax_update(frm){
    const formData=$("#record_info").serializeObject();
    $.ajax({
            url:'http://localhost:8080/ds-sw/question/update',
            type:'PUT',
            contentType:'application/json',
            data:JSON.stringify(formData),
            success:function(data){
                console.log(data.data);
            },error:function(xhr,status,error){
                console.log("["+xhr.status+"]"+error);
            }
        });
    location.reload();
    return false;

}


function ajax_delete(frm){
    const id=document.getElementById("id").value;
    const param={"id":id};
    $.ajax({
        url:'question/delete',
        type:'DELETE',
        data:param,
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    location.reload();
    return false;
}