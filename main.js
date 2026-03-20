document.addEventListener("DOMContentLoaded", function () {
    const profile = {
        fullName: "Nguyễn Văn Thuận",
        birthYear: 2004,
        school: "Đại học Công nghệ TPHCM",
        major: "Công nghệ thông tin",
        bio: "Minh yêu thích lập trình web, học công nghệ mới và xây dựng các dự án nhỏ để nâng cao kỹ năng."
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
