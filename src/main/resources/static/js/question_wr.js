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



function removeAllchild(div){
    while(div.hasChildNodes()){
        div.removeChild(div.firstChild);
    }
}

function getHealth(e){
    if (e.target !== e.currentTarget)
        return;
    e.preventDefault();
    const button = e.target;
    let listChild=button.childNodes;
    let id=document.getElementById("id");
    let title=document.getElementById("title");
    let time=document.getElementById("time");
    let food=document.getElementById("food");
    id.style.display = "block";
    document.getElementById("id_label").style.display = "block";
    id.value=listChild[0].innerHTML;
    title.value=listChild[1].innerHTML;
    time.value=listChild[2].innerHTML;
    food.value=listChild[3].innerHTML;

}

function ajax_get(){
    const currentDiv=document.getElementById('records');
    removeAllchild(currentDiv);
    $.ajax({
            url : "question/retrieve",
            dataType :"json",
            success : function(data) {
                        let d=data.data;

                        for (let i=0;i<d.length;i++){
                            const button=document.createElement("button");
                            const id=document.createElement("p");
                            const title=document.createElement("p");
                            const time=document.createElement("p");
                            const food=document.createElement("p");
                            id.setAttribute("id","bid");
                            title.setAttribute("id","btitle");
                            time.setAttribute("id","btime");
                            id.innerHTML=d[i]['id'];
                            title.innerHTML=d[i]['title']
                            time.innerHTML=d[i]['time']
                            food.innerHTML=d[i]['food'];

                            button.appendChild(id);
                            button.appendChild(title);
                            button.appendChild(time);
                            button.appendChild(food);

                            button.setAttribute('class',"btn btn-light");
                            button.addEventListener('click',getHealth);
                            currentDiv.appendChild(button);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
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
    document.getElementById("id").style.display = "none";
    document.getElementById("id_label").style.display = "none";
    clear();
    return false;
}

function ajax_update(frm){
    const formData=$("#record-form").serializeObject();
    $.ajax({
            url:'question/update',
            type:'PUT',
            contentType:'application/json',
            data:JSON.stringify(formData),
            success:function(data){
                console.log(data.data);
            },error:function(xhr,status,error){
                console.log("["+xhr.status+"]"+error);
            }
        });
    document.getElementById("id").style.display = "none";
    document.getElementById("id_label").style.display = "none";
    clear();
    return false;

}