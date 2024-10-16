# Sử dụng hình ảnh ASP.NET Core SDK để xây dựng ứng dụng
FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build-env
WORKDIR /app

# Copy toàn bộ mã nguồn và thực hiện build dự án
COPY . ./
RUN dotnet publish -c Release -o out

# Sử dụng hình ảnh ASP.NET Core runtime để chạy ứng dụng
FROM mcr.microsoft.com/dotnet/aspnet:7.0
WORKDIR /app
COPY --from=build-env /app/out .
RUN dotnet dev-certs https --trust

# Chạy ứng dụng
ENTRYPOINT ["dotnet", "testapp.dll"]

#docker build -t testapp-dotnet7:1.0 .
