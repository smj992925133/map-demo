import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage>
    with AutomaticKeepAliveClientMixin {
  var mheight = 300.0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  var mh = 0.0;

  @override
  Widget build(BuildContext context) {
    super.build(context);
    return Scaffold(
        appBar: AppBar(
          title: Text("地图"),
        ),
        body: Stack(
          children: [
            Container(
              width: MediaQuery.of(context).size.width,
              height: MediaQuery.of(context).size.height - mh,
              child: AndroidView(
                viewType: "threemonitor",
                creationParamsCodec: const StandardMessageCodec(),
                onPlatformViewCreated: (id) {},
              ),
            ),
            Positioned(
              left: 50,
                top: 50,
                child:GestureDetector(
                  onTap: (){
                    setState(() {
                      if(mh==0){
                        mh=300.0;
                      }else{
                        mh=0;
                      }
                    });

                  },
                  child:  Container(
                    child: Icon(
                      Icons.close,
                      size: 30,
                    ),
                  ),
                )
            )
          ],
        ));
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}
