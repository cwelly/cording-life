using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class movecontrolOVRFINAL : MonoBehaviour {

    // Use this for initialization
    public int speedForward = 12; //전진속도
    public int speediSide = 6; //옆걸음 속도
    public GameObject sound;
    private Transform tr;
    private float dirX = 0;
    private float dirZ = 0;

    void Start()
    {
        tr = GetComponent<Transform>();
    }

    // Update is called once per frame
    void Update()
    {
        MovePlayer();
    }

    //주인공 이동
    void MovePlayer()
    {
        dirX = 0; //좌우 이동 방향(왼쪽:-1, 오른쪽:1)
        dirZ = 0; //전진 후진 이동 방향(후진 :-1, 전진: 1)

        if (OVRInput.Get(OVRInput.Button.PrimaryTouchpad))
        {
            sound.SendMessage("enableSound");
            Vector2 coord = OVRInput.Get(OVRInput.Axis2D.PrimaryTouchpad,
                OVRInput.Controller.RTrackedRemote);
            var absX = Mathf.Abs(coord.x);
            var absY = Mathf.Abs(coord.y);
            if (absX > absY)
            {
                //Right
                if (coord.x > 0)
                    this.transform.Translate(Vector3.right * 2.0f * Time.smoothDeltaTime);
                //Left
                else
                    this.transform.Translate(Vector3.left * 2.0f * Time.smoothDeltaTime);
            }
            else
            {
                //up
                if (coord.y > 0)
                    this.transform.Translate(Vector3.forward * 2.0f * Time.smoothDeltaTime);
                //Down
                else
                    this.transform.Translate(Vector3.back * 2.0f * Time.smoothDeltaTime);
            }
        }
        if (OVRInput.GetUp(OVRInput.Button.PrimaryTouchpad)) {
            sound.SendMessage("disableSound");
        }
        //이동 방향 설정 후 이동

    }
}
