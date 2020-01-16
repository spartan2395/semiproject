window.onload = function () {
    var eventlist = document.getElementsByClassName("select");

    for (var i = 0; i < eventlist.length; i++) {
        eventlist[i].addEventListener("click", function (event) {
            event.preventDefault();
            if (this.getAttribute("id") == "indiv") {
                document.getElementById("login_member_bg").setAttribute('src', 'resources/imgs/login_member.svg');
                document.getElementById("register").setAttribute('href', 'newMember.html');
                document.getElementById("id").setAttribute('name','member_id');
                document.getElementById("pw").setAttribute('name','member_pw');

            } else if (this.getAttribute("id") == "doc") {
                document.getElementById("login_member_bg").setAttribute('src', 'resources/imgs/login_doctor.svg');
                document.getElementById("register").setAttribute('href', 'newDoctor.html');
                document.getElementById("id").setAttribute('name','doc_id');
                document.getElementById("pw").setAttribute('name','doc_pw');

            }
        })
    }
}