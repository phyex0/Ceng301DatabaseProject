# Ceng301DatabaseProject

<p> 
How to enable connection ?

1) Open SQL Server Configuration Manager, and then expand SQL Server 2019 Network Configuration.
2) Click Protocols for InstanceName, and then make sure TCP/IP is enabled in the right panel and double-click TCP/IP.
3) On the Protocol tab, notice the value of the Listen All item.
4) Click the IP Addresses tab: If the value of Listen All is yes, the TCP/IP port number for this instance of SQL Server 2019 is the value of the TCP Dynamic Ports item under IPAll. If the value of Listen All is no, the TCP/IP port number for this instance of SQL Server 2019 is the value of the TCP Dynamic Ports item for a specific IP address.
5) Make sure the TCP Port is 1433.
6) Click OK.
</p>
