function ajax_send(frm){
    const formData=$("#record-form").serializeObject();
    $.ajax({
        url:'record/create',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(formData),
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    return false;
}

function removeAllchild(div){
    while(div.hasChildNodes()){
        div.removeChild(div.firstChild);
    }
}

function ajax_get(){
    const currentDiv=document.getElementById('records');
    removeAllchild(currentDiv);
    $.ajax({
            url : "record/retrieve", // test.jsp 에서 받아옴
            dataType :"json", // 데이터타입을 json 으로 받아옴
            success : function(data) {
                        let d=data.data;

                        for (let i=0;i<d.length;i++){
                            const card=document.createElement("div");
                            card.setAttribute('class',"card");

                            const cardDiv=document.createElement("div");
                            cardDiv.setAttribute('class',"card-body");

                            const title=document.createElement("h5");
                            title.setAttribute('class','card-title');
                            title.innerHTML="exercise: "+d[i]['title'];

                            const time=document.createElement("h6");
                            time.setAttribute('class',"card-subtitle mb-2 text-muted")
                            time.innerHTML="time: "+d[i]['time'];

                            const food=document.createElement("h6");
                            food.setAttribute('class',"card-subtitle mb-2 text-muted")
                            food.innerHTML="food: "+d[i]['food'];

                            cardDiv.appendChild(title);
                            cardDiv.appendChild(time);
                            cardDiv.appendChild(food);

                            card.appendChild(cardDiv);
                            currentDiv.appendChild(card);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
}