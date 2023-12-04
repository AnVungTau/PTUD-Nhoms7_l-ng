use QLLuongSP

select * from BangPhanCong pc join CongNhan cn on pc.maCN = cn.maCN join CongDoan cd on cd.maCD = pc.maCD 
join SanPham sp on sp.maSP = cd.maSP join BangChamCongCongNhan bcccn on bcccn.maCN = pc.maCN and bcccn.maCD = pc.maCD 
where sp.maSP = 'SP000001' and cd.maCD = 'CD000001' and pc.trangThai = 0

/*Tính tổng số lượng làm được*/
SELECT 
    pc.maCN,
    pc.maCD,
    pc.ngayPhanCong,
    pc.soLuongPhanCong,
    SUM(cc.soLuongLam) AS TongSoLuongLam
FROM 
    BangPhanCong pc
INNER JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND pc.ngayPhanCong = cc.ngayPhanCong
WHERE
    pc.maCN = 'CN000001'
    AND pc.maCD = 'CD000001'
    AND pc.ngayPhanCong = '2023-11-29'
GROUP BY 
    pc.maCN, pc.maCD, pc.ngayPhanCong, pc.soLuongPhanCong;

select * from BangPhanCong

Select * from BangPhanCong pc join CongNhan cn on cn.maCN = pc.maCN join CongDoan cd on cd.maCD = pc.maCD join SanPham sp on sp.maSP = cd.maSP
/*Cập nhật trạng thái hoàn thành của bảng phân công*/
UPDATE pc
SET pc.trangThai = 
    CASE 
        WHEN result.TongSoLuongLam >= pc.soLuongPhanCong THEN 1
        ELSE 0
    END
FROM BangPhanCong pc
INNER JOIN (
    SELECT 
        pc.maCN,
        pc.maCD,
        pc.ngayPhanCong,
        SUM(cc.soLuongLam) AS TongSoLuongLam
    FROM 
        BangPhanCong pc
    INNER JOIN 
        BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND pc.ngayPhanCong = cc.ngayPhanCong
		/*
    WHERE
        pc.maCN = 'CN000001'
        AND pc.maCD = 'CD000001'
        AND pc.ngayPhanCong = '2023-11-29'*/
    GROUP BY 
        pc.maCN, pc.maCD, pc.ngayPhanCong
) AS result ON pc.maCN = result.maCN AND pc.maCD = result.maCD AND pc.ngayPhanCong = result.ngayPhanCong;

select * from HopDong

select * from SanPham

delete from HopDong where maHD = 'HD000005'
delete from SanPham where maSP = 'SP000004'

select *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD

select *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD

SELECT *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD WHERE sp.tenSP LIKE '%g%'

select * from CongDoan

SELECT 
    pc.maCN,
    pc.maCD,
    pc.ngayPhanCong,
    SUM(cc.soLuongLam) AS TongSoLuongLam
FROM 
    BangPhanCong pc
INNER JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND pc.ngayPhanCong = cc.ngayPhanCong
GROUP BY 
    pc.maCN, pc.maCD, pc.ngayPhanCong;


/*Lấy danh sách chấm công*/
SELECT pc.*
FROM BangPhanCong pc
JOIN CongNhan cn ON pc.maCN = cn.maCN
LEFT JOIN BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND pc.ngayPhanCong = cc.ngayPhanCong
WHERE cn.maTo = 2
  AND pc.ngayPhanCong = '2023-11-29'
  AND pc.maCD = 'CD000001'
  AND cc.maCN IS NULL;


/*==================================================*/


select * from BangPhanCong
select * from BangChamCongCongNhan
/*Toàn bộ danh sách chưa được chấm vào ngày ..... */
SELECT 
    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong, 
	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam
FROM 
    BangPhanCong pc
LEFT JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = '2023-12-01'
JOIN 
    CongNhan cn ON pc.maCN = cn.maCN
JOIN
	CongDoan cd ON cd.maCD = pc.maCD
JOIN
	SanPham sp ON sp.maSP = cd.maSP
WHERE 
    cc.maCN IS NULL
    AND cc.maCD IS NULL;


select * from BangPhanCong
select * from BangChamCongCongNhan
/*Lấy theo tổ*/
SELECT 
    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong, 
	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam
FROM 
    BangPhanCong pc
LEFT JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = '2023-12-01'
JOIN 
    CongNhan cn ON pc.maCN = cn.maCN
JOIN
	CongDoan cd ON cd.maCD = pc.maCD
JOIN
	SanPham sp ON sp.maSP = cd.maSP
WHERE 
    cc.maCN IS NULL
    AND cc.maCD IS NULL
    AND cn.maTo = 1;


select * from BangPhanCong
select * from BangChamCongCongNhan
/*Lấy theo công đoạn*/
SELECT 
    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong, 
	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam
FROM 
    BangPhanCong pc
LEFT JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = '2023-12-01'
JOIN 
    CongNhan cn ON pc.maCN = cn.maCN
JOIN
	CongDoan cd ON cd.maCD = pc.maCD
JOIN
	SanPham sp ON sp.maSP = cd.maSP
WHERE 
    cc.maCN IS NULL
    AND cc.maCD IS NULL
    AND pc.maCD = 'CD000005';


select * from BangPhanCong
select * from BangChamCongCongNhan
/*Lấy ds theo tổ và Cđ*/
SELECT 
    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong, 
	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam
FROM 
    BangPhanCong pc
LEFT JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = '2023-12-01'
JOIN 
    CongNhan cn ON pc.maCN = cn.maCN
JOIN
	CongDoan cd ON cd.maCD = pc.maCD
JOIN
	SanPham sp ON sp.maSP = cd.maSP
WHERE 
    cc.maCN IS NULL
    AND cc.maCD IS NULL
    AND cn.maTo = 2
    AND pc.maCD = 'CD000001';


select * from BangPhanCong
select * from BangChamCongCongNhan
/*Lấy danh sách đã chấm*/
SELECT 
    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong, 
	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam
FROM 
    BangPhanCong pc
JOIN 
    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD
JOIN 
    CongNhan cn ON pc.maCN = cn.maCN
JOIN
	CongDoan cd ON cd.maCD = pc.maCD
JOIN
	SanPham sp ON sp.maSP = cd.maSP
WHERE 
    cc.ngayChamCong = '2023-12-01'
