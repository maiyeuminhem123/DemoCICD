document.addEventListener("DOMContentLoaded", function () {
    const profile = {
        fullName: "Nguyễn Văn Thuận ",
        birthYear: 2004,
        school: "Dai hoc Công nghệ TPHCM",
        major: "Cong nghe thong tin",
        bio: "Minh yeu thich lap trinh web, hoc cong nghe moi va xay dung cac du an nho de nang cao ky nang."
    };

    const currentYear = new Date().getFullYear();
    const age = currentYear - profile.birthYear;

    document.getElementById("fullName").textContent = profile.fullName;
    document.getElementById("birthYear").textContent = String(profile.birthYear);
    document.getElementById("age").textContent = String(age);
    document.getElementById("school").textContent = profile.school;
    document.getElementById("major").textContent = profile.major;
    document.getElementById("bio").textContent = profile.bio;
});
