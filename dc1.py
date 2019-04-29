import socket
print("====================================")
print("||      DC1配网工具 By flymyd      ||")
print("|| E-mail: qq2663797538@gmail.com ||")
print("||   GitHub: github.com/flymyd    ||")
print("====================================")
print("*****************************************************************************")
print("1. 请长按DC1的总开关3-5秒至WiFi连接灯快速闪烁，然后用本机连接PHI_PLUG1_xxxx的开放WiFi")
print("2. 准备工作完成后请按提示输入WiFi配置，退出请按Ctrl+C")
print("*****************************************************************************")
ssid = input("请输入待连接的WiFi SSID（仅支持2.4G）: ")
password = input("请输入待连接的WiFi密码: ")
send_data = "{\"header\":\"phi-plug-0001\",\"uuid\":\"00010\",\"action\":\"wifi=\",\"auth\":\"\",\"params\":{\"ssid\":\""+ssid+"\",\"password\":\""+password+"\"}}\n"
for i in range(5):
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_socket.sendto(send_data.encode("utf-8"), ("192.168.4.1", 7550))
    udp_socket.close()
print("发送配网数据成功！请检查DC1连接状况。")