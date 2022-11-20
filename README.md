# TetraNetFix


Technical stuff: 
In some weird cases Tetras netcode breaks down.
As far as my analysis of this goes, it seems to happen in bigger modpacks probably due to different behaviour loading behaviour and optimasations for either client or server.
This may lead to a different order for the packets to be registered in server and client.
This mod injects directly after Tetra initialises its Packethandler and forces a specific ordering of the packets.
Multil already prevents double regestrations of Packets.
