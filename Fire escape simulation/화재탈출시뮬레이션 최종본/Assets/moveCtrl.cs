using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using VR = UnityEngine.VR;

public class moveCtrl : MonoBehaviour
{
    string axisX;
    float VRaxis;
    public GameObject sound;
    //private OVRCameraRig camera;

    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.W))
        {
            this.transform.Translate(Vector3.forward * 2.0f * Time.deltaTime);
        }
        else if (Input.GetKeyUp(KeyCode.W) || Input.GetKeyUp(KeyCode.S) || Input.GetKeyUp(KeyCode.A) || Input.GetKeyUp(KeyCode.D))
        {
            sound.SendMessage("disableSound");
        }

        if (Input.GetKey(KeyCode.S))
        {
            this.transform.Translate(Vector3.back * 2.0f * Time.deltaTime);
        }
        else if (Input.GetKeyUp(KeyCode.W) || Input.GetKeyUp(KeyCode.S) || Input.GetKeyUp(KeyCode.A) || Input.GetKeyUp(KeyCode.D))
        {
            sound.SendMessage("disableSound");
        }

        if (Input.GetKey(KeyCode.A))
        {
            this.transform.Translate(Vector3.left * 2.0f * Time.deltaTime);
        }
        else if (Input.GetKeyUp(KeyCode.W) || Input.GetKeyUp(KeyCode.S) || Input.GetKeyUp(KeyCode.A) || Input.GetKeyUp(KeyCode.D))
        {
            sound.SendMessage("disableSound");
        }

        if (Input.GetKey(KeyCode.D))
        {
            this.transform.Translate(Vector3.right * 2.0f * Time.deltaTime);
        }
        else if(Input.GetKeyUp(KeyCode.W)|| Input.GetKeyUp(KeyCode.S)|| Input.GetKeyUp(KeyCode.A)|| Input.GetKeyUp(KeyCode.D))
        {
            sound.SendMessage("disableSound");
        }


        if (OVRInput.Get(OVRInput.Button.PrimaryTouchpad))
        {
            sound.SendMessage("enableSound");
            Vector2 coord = OVRInput.Get(OVRInput.Axis2D.PrimaryTouchpad, OVRInput.Controller.RTrackedRemote);
            var absX = Mathf.Abs(coord.x);
            var absY = Mathf.Abs(coord.y);
            if (absX > absY)
            {
                //Right
                if (coord.x > 0)
                    this.transform.Translate(Vector3.right * 2.0f * Time.deltaTime);
                //Left
                else
                    this.transform.Translate(Vector3.left * 2.0f * Time.deltaTime);
            }
            else
            {
                //up
                if (coord.y > 0)
                    this.transform.Translate(Vector3.back * 2.0f * Time.deltaTime);
                //Down
                else
                    this.transform.Translate(Vector3.forward * 2.0f * Time.deltaTime);
            }
        }
        else if(OVRInput.GetUp(OVRInput.Button.PrimaryTouchpad))
        {
            sound.SendMessage("disableSound");
        }

    }
}