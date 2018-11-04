let el = document.getElementById('mydiv1');
let el1 = document.getElementById('mydiv2');
function viewdiv() {
    var link = document.getElementById('toggleLink');
    if (el.style.display == "block") {
        el.style.display = "none";
        el1.style.display = "block";
        link.innerText = link.getAttribute('data-text-hide');
    } else {
        el.style.display = "block";
        el1.style.display = "none";
        link.innerText = link.getAttribute('data-text-show');
    }
}
