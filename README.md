# Ceng301DatabaseProject

<p> 
  How to enable connection ?

  1) Open SQL Server Configuration Manager, and then expand SQL Server 2019 Network Configuration.
  2) Click Protocols for InstanceName, and then make sure TCP/IP is enabled in the right panel and double-click TCP/IP.
  3) On the Protocol tab, notice the value of the Listen All item.
  4) Click the IP Addresses tab: If the value of Listen All is yes, the TCP/IP port number for this instance of SQL Server 2019 is the value of the TCP Dynamic Ports item under        IPAll. If the value of Listen All is no, the TCP/IP port number for this instance of SQL Server 2019 is the value of the TCP Dynamic Ports item for a specific IP address.
  5) Make sure the TCP Port is 1433.
  6) Click OK.
</p>


<p>
  How to enable sa profile ?
  
  1) Open Microsof SQL Server Management Studio.
  2) Connect to server with Windows Authentication without change anything.
  3) Under the your server name there is a security directory click it then click to Logins.
  4) Right click to sa and select properties.
  5) Select status on left side of the upcoming window.
  6) Enable the Login then click OK.
  7) Right click to your server (serverName\SQLEXPRESS) then select properties.
  8) Select security on left side of the upcoming window.
  9) Make server authentication to SQL Server and Windows Authentication.
  10) Click ok.
  11) Open Logins directory again like we did at step 3.
  12) Right click to sa and select properties.
  13) Set new password and confirm it.
  14) Press OK.
  15) Click to disconnect where is above the your server (serverName\SQLEXPRESS)
  16) Click to connect which is next to disconnect.
  17) Login with SQL Server Authentication
  18) Enter your password and hit to connect.
  19) Enjoy the database.  
 </p>
