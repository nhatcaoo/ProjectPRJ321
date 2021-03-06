USE [master]
GO
/****** Object:  Database [ProjectPRJ321]    Script Date: 11/12/2018 6:25:31 AM ******/
CREATE DATABASE [ProjectPRJ321]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectPRJ321', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLSERVER1\MSSQL\DATA\ProjectPRJ321.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProjectPRJ321_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLSERVER1\MSSQL\DATA\ProjectPRJ321_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProjectPRJ321] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectPRJ321].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectPRJ321] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectPRJ321] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectPRJ321] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectPRJ321] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProjectPRJ321] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectPRJ321] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProjectPRJ321] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectPRJ321] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectPRJ321] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectPRJ321] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectPRJ321] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectPRJ321', N'ON'
GO
USE [ProjectPRJ321]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[adminID] [int] NOT NULL,
	[adminName] [nvarchar](50) NOT NULL,
	[adminPass] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[adminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CafeProduct]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CafeProduct](
	[productID] [int] NOT NULL,
	[productName] [nvarchar](50) NULL,
	[productPrice] [money] NULL,
	[productShortDescription] [nvarchar](150) NULL,
	[productFullDescription] [nvarchar](max) NULL,
	[productImage] [nvarchar](50) NULL,
 CONSTRAINT [PK_CafeProduct] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contact]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[contactName] [nvarchar](max) NOT NULL,
	[contactAdress] [nvarchar](max) NOT NULL,
	[contactPhone] [int] NOT NULL,
	[contactEmail] [nvarchar](50) NOT NULL,
	[contactImage] [nvarchar](50) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Feature]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[featureID] [int] NOT NULL,
	[URL] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[featureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[featureID] [int] NOT NULL,
	[groupID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USER_Group]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER_Group](
	[username] [nvarchar](50) NOT NULL,
	[groupID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USERGROUP]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERGROUP](
	[groupID] [int] NOT NULL,
	[groupName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_USERGROUP] PRIMARY KEY CLUSTERED 
(
	[groupID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USERS]    Script Date: 11/12/2018 6:25:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Admin] ([adminID], [adminName], [adminPass]) VALUES (1, N'1', N'1')
INSERT [dbo].[Admin] ([adminID], [adminName], [adminPass]) VALUES (2, N'admin1', N'123456')
INSERT [dbo].[CafeProduct] ([productID], [productName], [productPrice], [productShortDescription], [productFullDescription], [productImage]) VALUES (1, N'Espresso', 100000.0000, N'Espresso sẽ có vị rất đậm và trên mặt có một lớp bọt màu nâu còn gọi là Crema rất thơm mà không đắng ngắt. ', N'Để có được một tách Espresso “chính hiệu” thì người ta phải rang những hạt café sẫm màu rồi xay rất nhuyễn, sau đó được pha chế bằng cách dùng nước nóng nén dưới áp suất cao. Nhờ vậy mà một tách Espresso sẽ có vị rất đậm và trên mặt có một lớp bọt màu nâu còn gọi là Crema rất thơm mà không đắng ngắt. Có kha khá nhiều những “tranh cãi” nảy lửa về phương thức làm ra một tách Espresso “tuyệt hảo” nhất, người thì nói rằng nguyên liệu cần phải có sự pha chế theo tỉ lệ 60% là café Arabica và 40% là Robusta, người thì lại “cương quyết” cho rằng chỉ có một tách Espresso với 100% là hạt café Arabica mới là “số dzách” cơ đấy.', N'Espresso.jpg')
INSERT [dbo].[CafeProduct] ([productID], [productName], [productPrice], [productShortDescription], [productFullDescription], [productImage]) VALUES (2, N'Macchiato', 10.0000, N'Trong tiếng Ý thì “Macchiato” có nghĩa là lốm đốm và cũng vì “cái tên” này mà có khá nhiều tranh cãi trong cách pha chế của loại đồ uống này.', N'Trong tiếng Ý thì “Macchiato” có nghĩa là lốm đốm và cũng vì “cái tên” này mà có khá nhiều tranh cãi trong cách pha chế của loại đồ uống này. Có người thì nói Macchiato là Espresso được cho thêm vài vệt sữa trên bề mặt tạo thành các đường vân trong khá đẹp mắt mà thôi. Tuy nhiên hiện nay thì nhiều quán café họ lại cho kha khá nhiều sữa vào tách Macchiato, thế nên có rất nhiều sự nhầm lẫn giữa Macchiato và Latte.', N'Macchiato.jpg')
INSERT [dbo].[CafeProduct] ([productID], [productName], [productPrice], [productShortDescription], [productFullDescription], [productImage]) VALUES (3, N'Latte', 10.0000, N'“Latte” được bắt nguồn từ từ Caffellatte trong tiếng Ý có nghĩa là café và sữa.', N'ó một điểm thú vị nữa là Latte lúc mới được “sáng tạo” là để dành riêng cho trẻ em vì lượng cafein trong này khá ít và có độ ngậy tương đối cao. Về sau thì dần dần chính người lớn cũng bị mê mẩn bởi thức uống này nên nó trở thành đồ uống cho mọi lứa tuổi.', N'Latte.jpg')
INSERT [dbo].[CafeProduct] ([productID], [productName], [productPrice], [productShortDescription], [productFullDescription], [productImage]) VALUES (4, N'Cappuccino ', 10.0000, N'Một tách café này cũng gồm có 3 phần là: café Espresso, sữa nóng và bọt sữa và thường được chia rất đều nhau nhá!', N'Một tách café này cũng gồm có 3 phần là: café Espresso, sữa nóng và bọt sữa và thường được chia rất đều nhau nhá! Tuy nhiên, tùy vào nơi pha chế mà lượng Espresso cũng khác nhau. Có nơi để nguyên Espresso đậm đặc nhưng lại có nơi pha loãng Espresso cùng với lượng nước gấp đôi. Và để hoàn thiện tách Cappucino thì không thể không nhắc đến “nghệ thuật vẽ” trên mặt lớp bọt sữa rồi', N'Cappuccino.jpg')
INSERT [dbo].[CafeProduct] ([productID], [productName], [productPrice], [productShortDescription], [productFullDescription], [productImage]) VALUES (5, N'Mocha', 10.0000, N'Mocha cũng được pha chế bằng hơi nước nên lượng cafein cũng rất ít.', N'Mocha cũng được pha chế bằng hơi nước nên lượng cafein cũng rất ít. Với mùi hương nhẹ của café trộn với vị ngọt dịu của kem và chocolate, lại còn không gây mất ngủ, lo lắng vì sợ nóng, Mocha luôn được coi là thức uống “ưa thích bậc nhất” cho mọi lứa tuổi.', N'Mocha.jpg')
INSERT [dbo].[Contact] ([contactName], [contactAdress], [contactPhone], [contactEmail], [contactImage]) VALUES (N'Coffee MeowMeow', N'Đại Học FPT-KM29-Đại Lộ Thăng Long', 1688190399, N'anhnnse06147@fpt.edu.vn', N'cafebackgr.jpg')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (1, N'/list')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (2, N'/insert')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (3, N'/update')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (4, N'/dele')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (5, N'/select')
INSERT [dbo].[Feature] ([featureID], [URL]) VALUES (6, N'/login')
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (3, 1)
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (4, 1)
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (2, 2)
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (5, 2)
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (6, 2)
INSERT [dbo].[Role] ([featureID], [groupID]) VALUES (6, 3)
INSERT [dbo].[USER_Group] ([username], [groupID]) VALUES (N'anhnnse06147', 1)
INSERT [dbo].[USER_Group] ([username], [groupID]) VALUES (N'sonnt5', 2)
INSERT [dbo].[USERGROUP] ([groupID], [groupName]) VALUES (1, N'admin')
INSERT [dbo].[USERGROUP] ([groupID], [groupName]) VALUES (2, N'member')
INSERT [dbo].[USERS] ([username], [password]) VALUES (N'anhnnse06147', N'123456')
INSERT [dbo].[USERS] ([username], [password]) VALUES (N'sonnt5', N'123456')
ALTER TABLE [dbo].[USER_Group]  WITH CHECK ADD  CONSTRAINT [FK_USER_Group_USERGROUP] FOREIGN KEY([groupID])
REFERENCES [dbo].[USERGROUP] ([groupID])
GO
ALTER TABLE [dbo].[USER_Group] CHECK CONSTRAINT [FK_USER_Group_USERGROUP]
GO
ALTER TABLE [dbo].[USER_Group]  WITH CHECK ADD  CONSTRAINT [FK_USER_Group_USERS] FOREIGN KEY([username])
REFERENCES [dbo].[USERS] ([username])
GO
ALTER TABLE [dbo].[USER_Group] CHECK CONSTRAINT [FK_USER_Group_USERS]
GO
USE [master]
GO
ALTER DATABASE [ProjectPRJ321] SET  READ_WRITE 
GO
