using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using VR = UnityEngine.VR;

public class moveCtrl : MonoBehaviour {
    string axisX;
    float VRaxis;
    //private OVRCameraRig camera;

    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKey(KeyCode.W)) {
            this.transform.Translate(Vector3.forward * 2.0f * Time.deltaTime);
        }
        if (Input.GetKey(KeyCode.S))
        {
            this.transform.Translate(Vector3.back * 2.0f * Time.deltaTime);
        }
        if (Input.GetKey(KeyCode.A))
        {
            this.transform.Rotate(0.0f, -150.0f * Time.deltaTime, 0.0f);
        }
        if (Input.GetKey(KeyCode.D))
        {
            this.transform.Rotate(0.0f, 150.0f * Time.deltaTime, 0.0f);
        }


        if (OVRInput.Get(OVRInput.Button.PrimaryTouchpad))
        {
            this.transform.Translate(Vector3.forward * 2.0f * Time.deltaTime);
        }
    }
}
