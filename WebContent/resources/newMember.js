window.onload = function () {
    var arraylist = document.getElementsByTagName("input");

    for (var i = 0; i < arraylist.length; i++) {
        arraylist[i].addEventListener("focusin", function () {
            this.parentElement.style.border = "1px inset #daeff7";
            if(this.value==""){
                this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            } else {
                this.parentElement.parentElement.lastElementChild.innerHTML=""
            }
        })
        arraylist[i].addEventListener("focusout", function () {
            this.parentElement.style.border = "solid 1px #75adc7";
            if(this.value==""){
                this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            } else {
                this.parentElement.parentElement.lastElementChild.innerHTML=""
            }
        })
    }

    for (var i = 0; i < arraylist.length; i++) {
        if (arraylist[i].value !=null){
            
        }
    }
};
