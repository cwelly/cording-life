using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class EyeCast : MonoBehaviour {

    private Transform tr;
    private Ray ray;
    private RaycastHit hit;
    private float dist = 20.0f;

    private GameObject currButton;
    private GameObject prevButton;

    private bool isClicked;


    // Use this for initialization
    void Start () {

    }

    // Update is called once per frame
    void Update () {
        ray = new Ray(tr.position, tr.forward * dist);

        buttonClicked();
	}

    void buttonClicked() {
        currButton = hit.collider.gameObject;
        prevButton = currButton;

        PointerEventData data = new PointerEventData(EventSystem.current);

        if (currButton.tag == "button")
        {
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger))
            {
                ExecuteEvents.Execute(currButton, data, ExecuteEvents.pointerEnterHandler);

            }
            else if (OVRInput.GetDown(OVRInput.Button.PrimaryIndexTrigger))
            {
                ExecuteEvents.Execute(currButton, data, ExecuteEvents.pointerEnterHandler);

            }

            else if (OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger))
            {
                ExecuteEvents.Execute(currButton, data, ExecuteEvents.pointerClickHandler);


            }
        }
        else if (prevButton != null) {
            //평상시 이미지 복원
            ExecuteEvents.Execute(currButton, data, ExecuteEvents.pointerExitHandler);

        }
    }
}
