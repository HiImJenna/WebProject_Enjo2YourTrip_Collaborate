const [plusBtn, writeBtn] = document.querySelector(".macgyver-btn")?.children;

window.onload = () => writeBtn.style.display="none";

plusBtn?.addEventListener('click', () => {
  if (writeBtn.style.display==="none"){
    writeBtn.style.display="inline";
  }else {
    writeBtn.style.display="none";
  }
});