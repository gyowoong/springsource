// Remove 클릭 시
const actionForm = document.querySelector("#actionForm");
document.querySelector(".btn-danger").addEventListener("click", (e) => {
  // actionForm action 수정
  if (!confirm("정말로 삭제하시겠습니까?")) {
    return;
  }
  actionForm.action = "/guestbook/remove";
  actionForm.submit();
});

// List 클릭 시
document.querySelector(".btn-info").addEventListener("click", (e) => {
  e.preventDefault();
  // actionForm method 수정(get)
  actionForm.method = "get";
  // gno 삭제
  actionForm.querySelector("[name='gno']").remove();
  actionForm.submit();
});
