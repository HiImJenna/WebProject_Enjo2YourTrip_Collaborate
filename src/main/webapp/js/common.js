const gatheringMore = document.querySelector(".gathering-more");
const reviewMore = document.querySelector(".review-more");
const iconify = document.querySelectorAll("iconify-icon");
const registerBtn = document.querySelector(".register-btn");
const tableRow = document.querySelectorAll("tr");
const modal = document.querySelector(".modal");

tableRow?.forEach(element => {
   element.addEventListener("click", e => {
    modal.style.display = "flex";
  })
})

modal?.addEventListener("click", e => {
  if(e.target.classList.contains("modal")) {
      modal.style.display = "none"
  }
})


registerBtn?.addEventListener('click', () => location.href="register.html");

gatheringMore?.addEventListener('click', () => location.href="culture-gathering.html");

reviewMore?.addEventListener('click', () => location.href="review.html" );


iconify.forEach(iconList => iconList?.addEventListener('click', e => {
  const href = (e.target.icon === "akar-icons:text-align-justified" )
               ? "menu.html" 
               : e.target.icon === "fe:login"
               ? "login.html"
               : e.target.icon === "fe:logout"
               ? "login.html"
               : e.target.icon === "bx:arrow-back"
               ? document.referrer
               : e.target.icon === "iconoir:edit-pencil"
               ? "write.html"
               : location.href;

    location.href = href;
}));

