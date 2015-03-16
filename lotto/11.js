////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
var port = 3000;////////////////////////////////////////////////////////////////////////////////////
var chNum = 4;//////////////////////////////////////////////////////////////////////////////////////

// 수정되는 변수 시작
//var chNum = 4; // 채널수 지정(4채널이면 4, 9채널이면 9, 16채널이면 16)
var logo = 1; // 1=자사
//var port;
// 수정되는 변수 끝



var _dvr = new Array();
var _nowDvr = 1;
var nowClient = 'client';
var oldmode;
var Audio_Ch;
var imgnum;



function Init()
{		
	var ip = 	document.location.hostname;	
	if (!port)	port = '3000';
	formip.ip.value = document.location.hostname;
	formport.port.value = port;

	_dvr[1] = null;		

	Init_btn();		
	
	Layer1.style.display = "inline";
	Layer1.style.left = 40;
	Layer1.style.top = 35;
	
	client.DisplayMgr.SetDisplayCount(chNum);
	client.DisplayMgr.SetLogo(logo);	

	oldModeSet();			
	
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Init_btn()
{
	playControl.style.display='none';
	search_setup.style.display='none';	
	layer_audio16.style.display='none';
	if(chNum==4) layer_quad.style.display='none';
}

function oldModeSet()
{
	oldmode = getCookie("mode"); // RGB(r) or GDI(g)
	if (!oldmode)	oldmode = 'r';
	if(oldmode == 'g'){		
		client.SetBltMode(9);		
		mode_1.src = "img/mode_gdi_on.gif";
	}	
	else if(oldmode == 'r'){
		client.SetBltMode(4);		
		mode_2.src = "img/mode_rgb_on.gif";
	}	
}

function connect()
{	
	var ip = 	document.formip.ip.value;
	var port = document.formport.port.value;
	var userid =document.formuserid.userid.value;
	var pass = document.formpass.pass.value;

	oldModeSet();
	if (ip == '' || port == '' || userid == '' || pass == '')	{
		alert("Input the connection info.");
	}
	else{
	disconnect();	
	_dvr[1] = client.ConnectDvr2(1, '', userid, pass, ip, port, '');
	}
	
	if(_dvr[1]){	

		register_port(port);		
		playControl.style.display = "none";		
		layer_audio16.style.display='block';
	}
	
}

function disconnect()
{	
	client.DisconnectDvr(1);
	_dvr[1] = null;
	
	Init_btn();
	layer_backup.style.display='none';
	search_setup.style.display='none';	
	layer_discon.style.display='none';	
	search_end.style.display='none';
}

function search(n)
{
	if(_dvr[1].CheckAuthority(16))	
			_dvr[1].DoSearch(n);
	else
		alert("No Authority.");
}
function toLive()
{	
	_dvr[1].DoLive();
	playControl.style.display='none';	

}
function play()
{	
	_dvr[1].PlaySpeed(1);
}
function ff()
{	
	_dvr[1].PlaySpeed(8);
}
function rew()
{	
	_dvr[1].PlaySpeed(-2);
}
function stop()
{	
	_dvr[1].PlaySpeed(3000);
}
function still()
{	
	var str;
	if (_dvr[1])
	{
		str = client.DisplayMgr.CaptureScreen(0);
    
		if(str)
			alert("Backup Information : \n\n" + str);
	}
    
}

function movie(st)
{	
	if(_dvr[1].CheckAuthority(8))
	{
		
		if(st == 'start' && _dvr[1]){
			_dvr[1].Backup(true);
		 }
		 else{
			_dvr[1].Backup(false);
		 }
	}
	else
	{
		alert("No Authority.");
	}

}
function config()
{		 
	if(_dvr[1].CheckAuthority(32))
	{
		 if(_dvr[1] && _dvr[1].CheckAuthority(32))	
			_dvr[1].Setup();
	}
	else
	{
		alert("No Authority.");
	}
}
function audio(ch,n)
{	  
	
	if(_dvr[1])
	{       
		_dvr[1].SetAudioChannel(n);		
		Audio_Btn(ch, n+1);
	}
	
}

function ptz(str)
{
	nnChannel = parseInt(nChannel.innerText);
	nnSpeed = parseInt(nSpeed.innerText);
	if (nnSpeed == 1){
		nnSpeed = 0;
	}else if (nnSpeed == 2){
		nnSpeed = 1;
	}else if (nnSpeed == 4){
		nnSpeed = 2;
	}

	if(_dvr[1] && _dvr[1].CheckAuthority(2))
	{
		if(str=='zoom_tele')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 8, nnSpeed);
		if(str=='zoom_wide')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 7, nnSpeed);
		if(str=='focus_far')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 10, nnSpeed);
		if(str=='focus_near')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 9, nnSpeed);
		if(str=='up')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 2, nnSpeed);
		if(str=='down')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 3, nnSpeed);
		if(str=='left')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 0, nnSpeed);
		if(str=='right')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 1, nnSpeed);
		if(str=='tour_start')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 26, nnSpeed);
		if(str=='tour_stop'){_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 27, nnSpeed);_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 5, nnSpeed);}
		if(str=='stop')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 5, nnSpeed);
		if(str=='iris_on')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 11, nnSpeed);
		if(str=='iris_off')_dvr[1].PanTilt(parseInt(nChannel.innerText)-1, 12, nnSpeed);
		if(str=='menu')_dvr[1].PanTilt(nnChannel-1, 22, nnSpeed);	
	}
	else
	{
		alert("No Authority.");
	}

}

function channelSet(st)
{
	nClientMax = chNum;
	nClientSu = parseInt(nChannel.innerText);
	
	if(st == "y"){
		if(nClientMax > nClientSu){				
			nChannel.innerText = nClientSu + 1;
		}
	}else if(st == "n"){
		if(nClientSu > 1){
			nChannel.innerText = nClientSu - 1;
		}
	}	
}

function btnDateInit(btn)
{
	btnREWm.src = "img/FDS_44.gif";
	btnSTOPm.src = "img/FDS_45.gif";
	btnPLAYm.src = "img/FDS_46.gif";
	btnFFm.src = "img/FDS_47.gif";
	btnEXITm.src = "img/FDS_live.gif";
	
	switch(btn)
	{
		case "btnREWm":
			document.all[btn].src = "img/FDS_44_over.gif";
			break;
		case "btnSTOPm":
			document.all[btn].src = "img/FDS_45_over.gif";
			break;
		case "btnPLAYm":
			document.all[btn].src = "img/FDS_46_over.gif";
			break;
		case "btnFFm":
			document.all[btn].src = "img/FDS_47_over.gif";
			break;
	
	}
}

function setCookie(name, value, expire) {
          document.cookie = name + "=" + escape(value) + ( (expire) ? "; expires=" + expire.toGMTString() : "")
}

function register1(objNm, uName) { 
          var today = new Date()
          var expire = new Date(today.getTime() + 60*60*24*3*1000)
          setCookie(objNm, uName, expire)
}

function getCookie(uName) {

	var flag = document.cookie.indexOf(uName+'=');
	if (flag != -1) { 
		flag += uName.length + 1
		end = document.cookie.indexOf(';', flag) 

		if (end == -1) end = document.cookie.length
		return unescape(document.cookie.substring(flag, end))
	}
}

function Audio_Btn(ch,Audio_Ch)
{

	for (i=1; i<ch+1; i++)
	{			
		if (ch == 16)
		{
			imgaudio = "audio" + i;
			imgnum = 60 + i + "";
			document.all[imgaudio].src = "img/FDS_" + imgnum + ".gif";
			if (Audio_Ch == i)
				document.all[imgaudio].src = "img/FDS_" + imgnum + "_over.gif";
			
		}
		if (ch == 8)
		{
			imgaudio = "audio8" + i;
			imgnum = 60 + i + "";
			document.all[imgaudio].src = "img/FDS_" + imgnum + ".gif";
			if (Audio_Ch == i)
				document.all[imgaudio].src = "img/FDS_" + imgnum + "_over.gif";
		}
		if (ch == 4)
		{
			imgaudio = "audio4_" + i;
			imgnum = 60 + i + "";
			document.all[imgaudio].src = "img/FDS_" + imgnum + ".gif";
			if (Audio_Ch == i)
				document.all[imgaudio].src = "img/FDS_" + imgnum + "_over.gif";
		}		
	}
}

function register2(uName) { 
          var today = new Date()
          var expire = new Date(today.getTime() + 60*60*24*3*1000)
          setCookie("mode", uName, expire)		
}
function register_port(uName) { 
	var today = new Date()
	var expire = new Date(today.getTime() + 60*60*24*3*1000)
	setCookie("port", uName, expire);	
}

function viewmode(mod) {	
	if(mod == 'gdi'){
		register2('g');
		alert("GDI Mode change.");;
	}
	if(mod == 'rgb'){
		register2('r');
		alert("RGB Mode change.");
	}
	window.location.reload();
}
function full_screen()
{	
 client.DisplayMgr.FullScreen();
}
function View4ch()
{	
	client.DisplayMgr.SetNextDisplay(4, 4); // case 16ch	
}
function presetView(st)
{	
	if (st=='view')
		layer_preset.style.display='';
	if (st=='hide')
		layer_preset.style.display='none';	
}
function presetMove(str)
{		
	 if(_dvr[1].CheckAuthority(2)){
		_dvr[1].PTZPreset(parseInt(nChannel.innerText)-1, 18, str);		
	 }
	else{	
		alert("No Authority.");	
	}	
}
function presetSave(str)
{	
		
	 if(_dvr[1].CheckAuthority(2)){
		_dvr[1].PTZPreset(parseInt(nChannel.innerText)-1, 17, str);		
	 }
	else{	
		alert("No Authority.");	
	}
}
function speedSet(st)
{
	nClientMax = 4;
	nClientSu = parseInt(nSpeed.innerText);
	
	if(st == "y"){		
		if (nClientSu == 1)
			nSpeed.innerText = 2;
		else 
			nSpeed.innerText = 4;
		
	}else if(st == "n"){		
		if (nClientSu == 4)
			nSpeed.innerText = 2;
		else
			nSpeed.innerText = 1;		
	}	
}


/**
 * 
 */