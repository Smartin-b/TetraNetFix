# TetraNetFix


Technical stuff: 
In some weird cases Tetras netcode breaks down.
As far as my analysis of this goes, it seems to happen in bigger modpacks probably due to different loading behaviour and optimizations for either client or server.
This may lead to a different order for the packets to be registered in server and client.
This mod injects directly after Tetra initializes its Packethandler and forces a specific ordering of the packets.
Mutil already prevents double registration of Packets.
